function handleTokenExpiration() {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'POST',
            url: '/auth/token',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            xhrFields: {
                withCredentials: true
            },
            success: (response) => {
                localStorage.setItem('accessToken', response.token);
                setupAjax(); // 새 토큰 적용
                resolve(); // ✅ resolve 호출
            },
            error: (error) => {
                localStorage.removeItem('accessToken');
                reject(error); // ✅ reject 호출
            }
        });
    });
}

function  setupAjax () {
    // 모든 Ajax 요청에 JWT Access Token을 포함
    $.ajaxSetup({
        beforeSend: function(xhr) {
            let token = localStorage.getItem('accessToken'); // 저장된 Access Token 가져오기
            if (token) {
                xhr.setRequestHeader('Authorization', 'Bearer ' + token); // Authorization 헤더에 Access Token 추가
            }
        }
    });
}

async function checkout() {
    let token = localStorage.getItem('accessToken');
    if (!token || token.trim() === '') {
        try {
            await handleTokenExpiration();
        } catch (e) {
            alert('로그인이 필요합니다. 다시 로그인해주세요.');
            window.location.href = '/users/login';
        }
    }
}

function logOut() {
    $.ajax({
        type: 'POST',
        url: '/logout', // 서버의 엔드포인트 URL
        contentType: 'application/json; charset=utf-8', // 전송 데이터의 타입
        success: (response) => {
            // 성공 시 실행될 콜백 함수
            alert('로그아웃 되었습니다.');
            // access token 제거
            localStorage.removeItem('accessToken');
            // 성공 후 로그인 페이지로 이동.
            window.location.href = '/users/login';
        },
        error: (error) => {
            // 실패 시 실행될 콜백 함수
            console.error('오류 발생:', error);
            alert('로그아웃 중 오류가 발생했습니다.');
        }
    });
}