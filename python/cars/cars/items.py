# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class TotalSalesItem(scrapy.Item):
    year = scrapy.Field()
    month = scrapy.Field()
    sales = scrapy.Field()


class KindSalesItem(scrapy.Item):
    car_name = scrapy.Field()
    year = scrapy.Field()
    month = scrapy.Field()
    sales = scrapy.Field()


class FactorySalesItem(scrapy.Item):
    factory_name = scrapy.Field()
    year = scrapy.Field()
    month = scrapy.Field()
    sales = scrapy.Field()


class CarsParamItem(scrapy.Item):
    car_name = scrapy.Field()
    factory_name = scrapy.Field()
    brand_name = scrapy.Field()
    car_type = scrapy.Field()
