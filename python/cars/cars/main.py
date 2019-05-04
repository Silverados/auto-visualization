from scrapy import cmdline
if __name__ == '__main__':
    # cmdline.execute("scrapy crawl car_total_spider".split())
    cmdline.execute("scrapy crawl car_kinds_spider".split())
    # cmdline.execute("scrapy crawl car_factory_spider".split())
    # cmdline.execute("scrapy crawl car_param_spider".split())