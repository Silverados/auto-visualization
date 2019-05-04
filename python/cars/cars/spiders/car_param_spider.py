# -*- coding: utf-8 -*-
import scrapy
from bs4 import BeautifulSoup
from cars.items import CarsParamItem


class CarParamSpiderSpider(scrapy.Spider):
    name = 'car_param_spider'
    allowed_domains = ['16888.com']
    start_urls = ['https://xl.16888.com/style.html']

    def parse(self, response):
        prev_url = "https://xl.16888.com"
        soup = BeautifulSoup(response.text, "lxml")
        table = soup.find(class_="xl-table-def xl-table-a")
        tr_list = table.find_all("tr")[1:]
        for i_item in tr_list:
            url = i_item.find_all(class_="lineBlock xl-td-btn")[1]['href']
            # yield car_item
            yield scrapy.Request(url, callback=self.parse2, dont_filter=True)

        next_link = soup.find(class_="lineBlock next")
        if next_link:
            yield scrapy.Request(prev_url + next_link["href"], callback=self.parse, dont_filter=True)

    def parse2(self, response):
        soup = BeautifulSoup(response.text, "lxml")
        menu = soup.find(class_="web_site-mun")
        # 您当前的位置：车主之家 > 车型大全 > 五菱汽车 > 上汽通用五菱 > 五菱宏光
        text = menu.get_text()[7::]
        keys = text.split(" > ")
        if not keys[2]:
            print(menu)
            print(soup.find(class_="J_show").get_text())
        car_item = CarsParamItem()
        car_item["brand_name"] = keys[2]
        car_item["factory_name"] = keys[3]
        car_item["car_name"] = keys[4]
        car_item["car_type"] = soup.find(class_="m_30").find("a").get_text().strip()
        yield car_item