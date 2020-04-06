pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
	buildDiscarder(logRotator(numToKeepStr: '3'))
	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle5.0_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout'){
		steps{
			echo "------------>Checkout<------------"
			checkout([
				$class: 'GitSCM', 
				branches: [[name: '*/develop']], 
				doGenerateSubmoduleConfigurations: false, 
				extensions: [], 
				gitTool: 'Default', 
				submoduleCfg: [], 
				userRemoteConfigs: [[
					credentialsId: 'GitHub_raulito1500', 
					url:'https://github.com/raulito1500/raul.cuellar_adn'
				]]
			])
		}
	}
	stage('Compile'){
		parallel {
			stage('Compile backend'){
				steps{
					echo "------------>Compilación backend<------------"
					dir("alcance-backend/microservicio"){
						sh 'gradle build -x test'
					}
				}
			
			}
		}
	}
    
      
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
