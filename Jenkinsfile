pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/zdesafios/WebHook-OctoEvents.git', changelog: true)
      }
    }
  }
}