package xyz.wywag.cars.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wywag.cars.entity.db.CarEntity;
import xyz.wywag.cars.mapper.ParamMapper;
import xyz.wywag.cars.service.ParamService;
import xyz.wywag.cars.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiyuwang
 * @since 2019/3/24 18:50
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    private ParamMapper paramMapper;

    @Override
    public String makeTree() {
        List<CarEntity> carEntities = paramMapper.listCars();
        Node root = new Node("车型");
        for (int i = 0; i < carEntities.size(); i++) {
            //brand_name 和 前一个不同的话 添加新的子节点
            Node brand = null;
            if (i == 0) {
                brand = new Node(carEntities.get(i).getBrandName());
                root.children.add(brand);
            } else if (carEntities.get(i).getBrandName().equals(carEntities.get(i - 1).getBrandName())) {
                brand = root.children.get(root.children.size() - 1);
            } else /*if (carEntities.get(i).getBrandName() != carEntities.get(i - 1).getBrandName())*/ {
                brand = new Node(carEntities.get(i).getBrandName());
                root.children.add(brand);
            }
            // brand_name 和 前一个相等
            // 判断 factory 是否相等
            Node factory = null;
            if (i == 0) {
                factory = new Node(carEntities.get(i).getFactoryName());
                brand.children.add(factory);
            } else if (carEntities.get(i).getFactoryName().equals(carEntities.get(i - 1).getFactoryName())) {
                factory = brand.children.get(brand.children.size() - 1);
            } else /*if (carEntities.get(i).getFactoryName() != carEntities.get(i - 1).getFactoryName())*/ {
                factory = new Node(carEntities.get(i).getFactoryName());
                brand.children.add(factory);
            }

            factory.children.add(new Node(carEntities.get(i).getCarName(), null));


        }
        return JsonUtil.toJson(root);
    }

    class Node {
        private String name;
        private List<Node> children;

        public Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }

        public Node(String name, List<Node> children) {

            this.name = name;
            this.children = children;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
