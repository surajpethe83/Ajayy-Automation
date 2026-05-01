pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/surajpethe83/Ajayy-Automation.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'test-output/**/*.*', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'test-output/*.xml'
        }

        success {
            emailext(
                subject: "SUCCESS: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
                body: "Build Passed ✅\nCheck details: ${env.BUILD_URL}",
                to: "automationtestingprogramming@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "FAILED: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
                body: "Build Failed ❌\nCheck details: ${env.BUILD_URL}",
                to: "automationtestingprogramming@gmail.com"
            )
        }
    }
}