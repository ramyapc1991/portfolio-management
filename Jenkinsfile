pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'building application'
                 withMaven(maven : 'apache-maven-3.6.1') {
                    sh 'mvn install'
                }
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
