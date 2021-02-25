pipeline {
  environment {
    registry = "ramyapc1991/portfolio-app"
    registryCredential = 'dockerhub'
  }
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git 'https://github.com/ramyapc1991/portfolio-management.git'
      }
    }
    stage('Building image') {
      steps{
        script {
          echo 'docker image building'
          docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
  }
}
