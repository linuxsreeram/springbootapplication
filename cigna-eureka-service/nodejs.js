node('') {
    stage('Checkout'){
        //Checkout the code from a GitHub repository
      git credentialsId: 'b744c4fa-359e-423d-81f9-99ab3d78714b', url: 'http://10.10.10.40/sreeram/cigma-eureka-service.git'
      }
    stage('build'){
        sh "/var/lib/jenkins/apache-maven-3.5.4/bin/mvn clean compile"
      }
       stage('create Image'){
	try {
		sh "sudo docker rm cigna-app:latest -f"
	} catch (Exception e) {
      		sh "echo no image found"
  	}
	sh '''
		sudo docker login -u admin -p Atmecs@123 nexus.atmecs.corp:8123
		sudo docker build -t cigna-app .
		sudo docker tag cigna-app:latest nexus.atmecs.corp:8123/docker-images:v.${BUILD_NUMBER}
		sudo docker push nexus.atmecs.corp:8123/docker-images:v.${BUILD_NUMBER}
		'''
      }
}
