pipeline {
    agent any

    tools {
        maven 'maven_3.9.9' // Use your Maven name from Jenkins (Global Tool Config)
        jdk 'jdk-21'        // Use your JDK name from Jenkins
    }

    environment {
        BRANCH_NAME = "${env.BRANCH_NAME}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ShubhamShivade/ems-backend.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Deploy (Optional)') {
            steps {
                echo "Deploy step goes here. (Docker run, SCP, etc.)"
                // bat './scripts/deploy.sh' or Docker commands
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
