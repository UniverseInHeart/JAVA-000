

改造自定义RPC的程序
1. 尝试将服务端写死查找接口实现类变成泛型和反射(老师课上已经完成)
2. 尝试将客户端动态代理改成AOP，添加异常处理（使用byteBuddy字节码增强，尝试使用注解模仿@DubboReference，感觉有点奇怪，麻烦老师指点一下）
3. 尝试使用Netty+HTTP作为client端传输方式(使用HttpClient)
