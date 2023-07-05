package com.MyBlog.project.pyrun;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonScriptRunner {
    public void runPythonScript() {
        try {
            // Python 스크립트 경로 설정
            String pythonScriptPath = "/src/main/resources/LSTM_Model.py";

            // Python 실행 명령어 설정
            String pythonCommand = "python " + pythonScriptPath;

            // 프로세스 빌더 생성
            ProcessBuilder pb = new ProcessBuilder(pythonCommand.split(" "));

            // 작업 경로 설정 (선택 사항)
            pb.directory(new File("C:\\Users\\smoke\\OneDrive\\바탕 화면"));

            // 프로세스 시작
            Process process = pb.start();

            // Python 스크립트의 출력을 읽기 위한 BufferedReader 생성
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // 출력 내용 처리 (원하는 대로 사용)
                System.out.println(line);
            }

            // 프로세스 종료까지 대기
            int exitCode = process.waitFor();
            System.out.println("Python script execution completed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
