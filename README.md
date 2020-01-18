# hmily-tcc
hmily框架整合springcloud,nacos开发运用

#项目介绍
hmily-order工程为订单服务，服务提供者，向nacos暴露服务
hmily-account工程为账单服务，服务提供者，向nacos暴露服务
hmily-business工程为业务服务，服务消费者，从nacos中拉取服务

hmily-business 同时调用hmily-order, hmily-account服务