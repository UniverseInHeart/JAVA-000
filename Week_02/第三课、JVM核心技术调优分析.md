## 多思考！多尝试！


### GC日志解读与分析

```
// 编译
javac GCLogAnalysis.java

// 打印GC细节
java -XX:+PrintGCDetails GCLogAnalysis

java -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:PrintGCDateStamps GCLogAnalysis

java -Xmn128m -Xmx128m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

java -Xmn256m -Xmx256m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -Xmn512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -Xmn1g -Xmx1g -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -Xmn2g -Xmx2g -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -Xmn4g -Xmx4g -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```


|  内存   | SerialGC  |ParallelGC  |CMS  |G1  |
|  ----  | ----  | ----  | ----  | ----  |
| 128M  | 频繁GC后OOM |频繁GC后OOM |频繁GC后OOM |频繁GC后OOM |
| 256M  | 3747 |2790 |3890 |频繁GC后OOM |
| 512M  | 6852 |5071 |7234 |7014 |
| 1G  |   7918 |5197 |8207 |8255 |
| 2G  |   8376 |5830 |7161 |7300  |
| 4G  |   7791 |6290 |7169 |8431  |

#### 串行GC
- 串行GC在小内存效率较高，管理大堆效率下降
- Full GC 只回收老年代内存

#### 并行GC
- Full GC 同时回收新生代和老年代内存


#### CMS
- 新生代使用ParNew
- 老年代CMS
```
CMS Initial Mark(STW) //初始标记
CMS-concurrent-mark-start
CMS-concurrent-mark  //并发标记  GC线程=
CMS-concurrent-preclean-start
CMS-concurrent-preclean //并发预处理
CMS-concurrent-abortable-preclean-start
CMS Final Remark(STW) //最终标记
CMS-concurrent-sweep-start
CMS-concurrent-sweep  //并发清除
CMS-concurrent-reset-start
CMS-concurrent-reset  //并发重置
```

#### G1
内存越大效率越高，大内存才能真正发挥G1的威力



** 设置堆内存过小，GC次数上升，可能发生OOM **
** 如果不设置Xms,第一次youngGC时内存较小，GC发生时间会提前**
