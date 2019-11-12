pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        git(url: 'https://github.com/zdesafios/WebHook-OctoEvents.git', changelog: true)
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean compile package -DskipTests'
      }
    }
  }
}