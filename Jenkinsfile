pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/CodingAutobots/Selenium4-Cucumber.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                // Add your build commands, e.g., ./gradlew build
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Add test commands
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Deployment steps
            }
        }
    }
}