/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2023-11-03 15:14
 * @Since:
 */
package com.zja.ocrmypdf.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: zhengja
 * @since: 2023/11/03 15:14
 */
@Slf4j
public class OCRmyPDFUtil {

    /**
     * 执行 OCRmyPDF 命令
     */
    public static void ocrCommand(String command) throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec(command);

        // 读取命令输出
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            log.info(line);
        }

        // 等待命令执行完成
        int exitCode = process.waitFor();

        if (exitCode != 0) {
            //命令执行失败
            String errorMessage = "OCRmyPDF 命令：" + command + "\n" +
                    "OCRmyPDF 执行命令错误信息：" +
                    getErrorMessage(process.getErrorStream());

            throw new RuntimeException(errorMessage);
        }
    }

    private static StringBuilder getErrorMessage(InputStream errorStream) throws IOException {
        // 获取错误输出流
        BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream));

        String line;
        StringBuilder errorMessage = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            errorMessage.append(line).append("\n");
        }

        return errorMessage;
    }

}
