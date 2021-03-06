# NeuSoup2

![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/t0ugh/hellospringboot)
![GitHub](https://img.shields.io/github/license/t0ugh/hellospringboot)
![GitHub last commit](https://img.shields.io/github/last-commit/t0ugh/hellospringboot)

### 1 功能分析

1. 登录注册
2. 发帖
3. 审帖
4. 搜索帖子
5. 各种排序，按照时间、按照热门程度等等
6. 点赞、评论、点踩
7. 加标签

### 2 技术栈

- mysql
- springboot
- mybatis
- springmvc
- redis
- rest风格的接口设计
- junit测试

### 3 计划

1. 设计数据库`er`模型的实现 + 表的设计

2. `POJO`的生成 + `Mapper`层 + `Service`层 + `ServiceTest`

3. `Controller`层 + `HttpClient`测试

#### 4 TODO

- [ ] 搜索功能欠缺
- [ ] `session`填补`userId`，而不是直接传递`userId`(不安全)
- [ ] `controller`的异常处理设计，资源没有找到，登录过期，内部抛出异常
- [ ] 各种`service`的异常情况处理设计
- [ ] 使用`MockMVC`对controller进行单元测试
- [ ] 缓存添加

