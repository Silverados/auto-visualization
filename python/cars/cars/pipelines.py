# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html
import pymysql
from cars.items import TotalSalesItem
from cars.items import KindSalesItem
from cars.items import FactorySalesItem
from cars.items import CarsParamItem


class CarsPipeline(object):

    def __init__(self, host, database, user, password, port):
        self.host = host
        self.database = database
        self.user = user
        self.password = password
        self.port = port

    @classmethod
    def from_crawler(cls, crawler):
        return cls(
            host=crawler.settings.get('MYSQL_HOST'),
            database=crawler.settings.get('MYSQL_DBNAME'),
            user=crawler.settings.get('MYSQL_USER'),
            password=crawler.settings.get('MYSQL_PASSWD'),
            port=crawler.settings.get('MYSQL_PORT'),
        )

    def open_spider(self, spider):
        self.db = pymysql.connect(self.host, self.user, self.password, self.database, charset='utf8',
                                  port=self.port)
        self.cursor = self.db.cursor()

    def close_spider(self, spider):
        self.db.close()

    def process_item(self, item, spider):
        # 插入数据
        if isinstance(item, TotalSalesItem):
            self.cursor.execute(
                """insert into total_sales(year, month, sales)
                value (%s, %s, %s)""",
                (item['year'],
                 item['month'],
                 item['sales'],))
        elif isinstance(item, KindSalesItem):
            self.cursor.execute(
                """insert into kind_sales(car_name, year, month, sales)
                value (%s, %s, %s, %s)""",
                (item['car_name'],
                 item['year'],
                 item['month'],
                 item['sales'],))
        elif isinstance(item, FactorySalesItem):
            self.cursor.execute(
                """insert into factory_sales(factory_name, year, month, sales)
                value (%s, %s, %s, %s)""",
                (item['factory_name'],
                 item['year'],
                 item['month'],
                 item['sales'],))
        elif isinstance(item, CarsParamItem):
            self.cursor.execute(
                """insert into car_param(car_name, factory_name, brand_name, car_type)
                value (%s, %s, %s, %s)""",
                (item['car_name'],
                 item['factory_name'],
                 item['brand_name'],
                 item['car_type'],))

        # 提交sql语句
        self.db.commit()
        return item
