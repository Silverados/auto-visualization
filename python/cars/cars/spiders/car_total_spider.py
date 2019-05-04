# -*- coding: utf-8 -*-
import scrapy
from bs4 import BeautifulSoup

from cars.items import TotalSalesItem


class CarSpiderSpider(scrapy.Spider):
    name = 'car_total_spider'
    allowed_domains = ['https://xl.16888.com']
    start_urls = ['https://xl.16888.com/month-1.html']

    def parse(self, response):
        soup = BeautifulSoup(response.text, "lxml")
        table = soup.find(class_="xl-table-def xl-table-a")
        tr_list = table.find_all("tr")[1:]
        for item in tr_list:
            sales_item = TotalSalesItem()
            time_str = item.find_all(class_="xl-td-t4")[0].string.split('-');
            sales_item["year"] = time_str[0]
            sales_item["month"] = time_str[1]
            sales = item.find_all(class_="xl-td-t4")[1].string
            sales_item["sales"] = sales
            yield sales_item
