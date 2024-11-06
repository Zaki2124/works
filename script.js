document.addEventListener('DOMContentLoaded', function() {
    const quizContainer = document.getElementById('quiz');
    const resultsContainer = document.getElementById('results');
    const submitButton = document.getElementById('submit');
    const progressBar = document.getElementById('progress-bar');

    const quizQuestions = [
        {
            question: "どんな気分の時に音楽を聴きたいですか？",
            answers: {
                a: "リラックスしたい時",
                b: "元気を出したい時",
                c: "集中したい時"
            }
        },
        {
            question: "好きなジャンルは？",
            answers: {
                a: "バラード",
                b: "ロック",
                c: "エレクトロニカ"
            }
        },
        {
            question: "EGOISTの好きな特徴は？",
            answers: {
                a: "歌詞",
                b: "メロディ",
                c: "ボーカル"
            }
        }
    ];

    const resultsMap = {
        "aaa": "The Everlasting Guilty Crown",
        "aab": "Departures ~あなたにおくるアイの歌~",
        "aac": "Planetes",
        "aba": "Extra terrestrial Biological Entities",
        "abb": "All Alone With You",
        "abc": "Namae no Nai Kaibutsu",
        "aca": "Reloaded",
        "acb": "Fallen",
        "acc": "KABANERI OF THE IRON FORTRESS",
        "baa": "Ghost of a smile",
        "bab": "Perfect Day",
        "bac": "LoveStruck",
        "bba": "Our animation",
        "bbb": "Kimi Sora Kiseki",
        "bbc": "All Alone With You",
        "bca": "Ghost of a smile",
        "bcb": "Extra terrestrial Biological Entities",
        "bcc": "Reloaded",
        "caa": "Extra terrestrial Biological Entities",
        "cab": "Fallen",
        "cac": "KABANERI OF THE IRON FORTRESS",
        "cba": "Planetes",
        "cbb": "Departures ~あなたにおくるアイの歌~",
        "cbc": "The Everlasting Guilty Crown",
        "cca": "Reloaded",
        "ccb": "All Alone With You",
        "ccc": "Namae no Nai Kaibutsu"
    };

    let currentQuestionIndex = 0;
    let userAnswers = [];

    function buildQuiz() {
        const currentQuestion = quizQuestions[currentQuestionIndex];
        const answers = [];
        for (let letter in currentQuestion.answers) {
            answers.push(
                `<label>
                    <input type="radio" name="question${currentQuestionIndex}" value="${letter}">
                    ${letter} : ${currentQuestion.answers[letter]}
                </label>`
            );
        }
        quizContainer.innerHTML = `
            <div class="question">${currentQuestion.question}</div>
            <div class="answers">${answers.join('')}</div>
        `;
    }

    function playBGM() {
        const audio = new Audio('path_to_your_bgm_file.mp3'); // ここにBGMファイルのパスを指定します
        audio.play();
    }

    function showNextQuestion() {
        const answerContainer = quizContainer.querySelector('.answers');
        const selector = `input[name=question${currentQuestionIndex}]:checked`;
        const userAnswer = (answerContainer.querySelector(selector) || {}).value;

        if (userAnswer) {
            userAnswers.push(userAnswer);
            playBGM(); // 回答するたびにBGMを再生します

            currentQuestionIndex++;
            updateProgress();
            if (currentQuestionIndex < quizQuestions.length) {
                buildQuiz();
            } else {
                showResults();
            }
        } else {
            alert("回答を選んでください");
        }
    }

    function updateProgress() {
        const progress = (userAnswers.length / quizQuestions.length) * 100;
        progressBar.style.width = `${progress}%`;
    }

    function showResults() {
        const resultKey = userAnswers.join('');
        const recommendedSong = resultsMap[resultKey] || "選択された曲はありません";
        resultsContainer.innerHTML = `あなたにおすすめの曲は: <strong>${recommendedSong}</strong>`;
        submitButton.style.display = 'none';
    }

    buildQuiz();
    submitButton.addEventListener('click', showNextQuestion);
});

