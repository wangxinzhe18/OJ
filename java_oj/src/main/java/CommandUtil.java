import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommandUtil {
    // 1.通过Runtime 类得到 Runtime 实例，执行exec 方法
    // 2.获取到标准输出并写入到指定文件中
    // 3.获取到标准错误 并写入到指定文件中
    // 4.等待进程结束 拿到子进程的状态码 并返回

    public static int run(String cmd, String stdoutFile, String stderrFile) {
        try {
            // 1. 通过Runtime类得到Runtime实例 执行exec 方法
            Process process = Runtime.getRuntime().exec(cmd);
            if (stdoutFile != null) {
              InputStream stdoutFrom =   process.getInputStream();
                FileOutputStream stdouTo = new FileOutputStream(stdoutFile);
                while (true) {
                   int ch =  stdoutFrom.read();
                   if (ch == -1) {
                       break;
                   }
                   stdouTo.write(ch);
                }
                stdoutFrom.close();
                stdouTo.close();
            }

            // 3. 获取到标准错误，并写入到指定文件
            if(stderrFile != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

