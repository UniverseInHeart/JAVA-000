## 作业
### 第一个版本-内存Queue
- [x] 基于内存Queue实现生产和消费API

  - [x] 1）创建内存BlockingQueue，作为底层消息存储
  - [x] 2）定义Topic，支持多个Topic
  - [x] 3）定义Producer，支持Send消息
  - [x] 4）定义Consumer，支持Poll消息

- [x] 2、去掉内存Queue，设计自定义Queue，实现消息确认和消费offset 

  - [x] 1）自定义内存Message数组模拟Queue。 
  - [x] 2）使用指针记录当前消息写入位置。 
  - [x] 3）对于每个命名消费者，用指针记录消费位置
  
  https://github.com/UniverseInHeart/JavaCourseCodes/tree/my/09mq/kmq-core

- [ ] 3、基于SpringMVC实现MQServer,拆分broker和client(包括producer和consumer) 

  - [ ] 1）将Queue保存到web server端 
  - [ ] 2）设计消息读写API接口，确认接口，提交offset接口 
  - [ ] 3）producer和consumer通过httpclient访问Queue 
  - [ ] 4）实现消息确认，offset提交 
  - [ ] 5）实现consumer从offset增量拉取

- [ ] 4、功能完善MQ,增加多种策略（各条之间没有关系，可以任意选择实现）

  - [ ] 1）考虑实现消息过期，消息重试，消息定时投递等策略 
  - [ ] 2）考虑批量操作，包括读写，可以打包和压缩 
  - [ ] 3）考虑消息清理策略，包括定时清理，按容量清理、LRU等 
  - [ ] 4）考虑消息持久化，存入数据库，或WAL日志文件，或BookKeeper 
  - [ ] 5）考虑将spring mvc替换成netty下的tcp传输协议，rsocket/websocket

- [ ] 5、体系完善MQ,对接各种技术（各条之间没有关系，可以任意选择实现） 

  - [ ] 1）考虑封装 JMS 1.1 接口规范 
  - [ ] 2）考虑实现 STOMP 消息规范 
  - [ ] 3）考虑实现消息事务机制与事务管理器 
  - [ ] 4）对接Spring 
  - [ ] 5）对接Camel或Spring Integration 
  - [ ] 6）优化内存和磁盘的使用

  
