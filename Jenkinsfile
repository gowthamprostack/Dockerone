pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                // Git clone repository
                git 'https://github.com/gowthamprostack/Dockerone.git'
            }
        }
        stage('Build') {
            steps {
                // Run your build commands here (e.g., Maven, Gradle)
                bat 'buildone.bat'  // For Windows
            }
        }
        stage('Publish JSON Report') {
            steps {
                // Archive the JSON reports from target/jsonReports
                archiveArtifacts artifacts: "C:/Users/mail2/.jenkins/workspace/Dockermaven/target/jsonReports/*.json", allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            // Example action for the always block
            echo 'This will run always after the pipeline completes.'
        }
    }
}
