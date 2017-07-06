tasks {
    "answer" {
        doLast {
            println(answerTheUltimateQuestionAboutLifeTheUniverseAndEveryting())
        }
    }
}

withHelloTask()

apply<MyPlugin>()