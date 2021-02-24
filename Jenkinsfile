pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building application'
                 sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application'
            }
        }
    }
}
