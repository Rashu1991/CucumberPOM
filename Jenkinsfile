pipeline{

agent any

stages{
	stage ('Compile Stage'){
		steps{
			withMaven(maven : 'testMaven'){
			sh 'mvn clean compile'
			}
		}
		
	}
	
	stage ('Testing Stage'){
		steps{
			withMaven(maven : 'testMaven'){
			sh 'mvn test'
			}
		}
		
	}
	
}
}
<<<<<<< HEAD:jenkinsfile
=======




}
>>>>>>> e31727e400c5d443efa8c9695e3a4db279b01157:Jenkinsfile
