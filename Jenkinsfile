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
	environment {
		PROJECT_PATH_BACK = 'alcance-backend'
		PROJECT_PATH_FRONT = 'alcance-frontend'
	}
	//Una sección que define las herramientas “preinstaladas” en Jenkins
	tools {
		jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
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
						dir("${PROJECT_PATH_BACK}/gestion_presupuesto"){
							sh 'chmod +x ./gradlew '
							sh './gradlew clean build -x test'
						}
					}
				
				}
				stage('Compile frontend'){
					steps {
						echo '------------>Compilación frontend<------------'

						dir("${PROJECT_PATH_FRONT}"){
							sh 'npm install'
						}
													
						dir("${PROJECT_PATH_FRONT}"){
							sh 'npm run ng build --configuration=production --outputHashing'
						}
					}
				}
			}
		}
		stage('Test Unitarios -Cobertura'){
			parallel {
				stage('Test - Cobertura backend'){
					steps {
						echo '------------>test backend<------------'
						dir("${PROJECT_PATH_BACK}/gestion_presupuesto"){
							sh './gradlew --stacktrace test'
						}
					}
				}
				stage('Test - Cobertura frontend'){
					steps{
						echo '------------>test frontend<------------'	
						dir("${PROJECT_PATH_FRONT}"){
							sh 'ng test --watch=false --browsers ChromeHeadless --code-coverage'	
						}
					}
				}
			}
		}
		stage('Sonar Analysis'){
			steps{
				echo '------------>Analisis de código estático<------------'
				  withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
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
			// junit 'alcance-backend/gestion_presupuesto/consulta/comando-dominio/build/reports/jacoco/test/*.xml' 
		}
		failure {
			echo 'This will run only if failed'
			mail (to: 'raul.cuellar@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
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
