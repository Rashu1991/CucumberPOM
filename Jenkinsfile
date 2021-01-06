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
<<<<<<< HEAD
<<<<<<< HEAD:jenkinsfile
=======




}
>>>>>>> e31727e400c5d443efa8c9695e3a4db279b01157:Jenkinsfile
=======
>>>>>>> 9522f2dd17c7c23e88b8910166952307d39415e3
