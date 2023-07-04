function runPythonScript() {
    fetch('/run-python-script')
        .then(response => {
            if (response.ok) {
                alert('전송 완료되었습니다🎉');
            } else {
                alert('전송 실패하였습니다😢');
            }
        })
        .catch(error => {
            console.error('An error occurred:', error);
            alert('전송 실패하였습니다😢');
        });
}