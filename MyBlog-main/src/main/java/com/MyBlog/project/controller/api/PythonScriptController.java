package com.MyBlog.project.controller.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PythonScriptController {

    @GetMapping("/run-python-script")
    public String runPythonScript() {
        try {
            // Python 스크립트 실행 코드
            String pythonScriptPath = "/src/main/resources/LSTM_Model.py";
            Process process = Runtime.getRuntime().exec(pythonScriptPath);
            process.waitFor();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}