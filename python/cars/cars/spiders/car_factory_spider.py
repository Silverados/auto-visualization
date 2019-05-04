# -*- coding: utf-8 -*-
import scrapy
from bs4 import BeautifulSoup

from cars.items import FactorySalesItem


class CarFactorySpiderSpider(scrapy.Spider):
    name = 'car_factory_spider'
    allowed_domains = ['xl.16888.com']
    start_urls = ['https://xl.16888.com/factory.html']

    def parse(self, response):
        prev_url = "https://xl.16888.com"
        soup = BeautifulSoup(response.text, "lxml")
        table = soup.find(class_="xl-table-def")
        # 去掉第一条
        tr_list = table.find_all("tr")[1:]
        # print(tr_list[1])
        for i_item in tr_list:
            sales_url = prev_url + i_item.find_all(class_="lineBlock xl-td-btn")[0]['href']
            yield scrapy.Request(sales_url, callback=self.parse2, dont_filter=True)

        next_link = soup.find(class_="lineBlock next")
        if next_link:
            yield scrapy.Request(prev_url + next_link["href"], callback=self.parse, dont_filter=True)

    def parse2(self, response):
        prev_url = "https://xl.16888.com"
        soup = BeautifulSoup(response.text, "lxml")
        table = soup.find(class_="xl-table-def xl-table-a")
        tr_list = table.find_all("tr")[1:]
        for i_item in tr_list:
            sales_item = FactorySalesItem()
            sales_item["factory_name"] = soup.find(class_="xl-level-head clr").find("span").get_text()[0:-4:]
            time_str = i_item.find_all(class_="xl-td-t4")[0].get_text().split('-')
            sales_item["year"] = time_str[0]
            sales_item["month"] = time_str[1]
            sales_item["sales"] = i_item.find_all(class_="xl-td-t4")[1].get_text()
            yield sales_item

        next_link = soup.find(class_="lineBlock next")
        if next_link:
            yield scrapy.Request(prev_url + next_link["href"], callback=self.parse2, dont_filter=True)

