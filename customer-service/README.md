Promethes Grafana
	1. Deployments are in monitoring name space, so create name space
		kubectl create ns monitoring
	2. Apply grafana deployment file - grafana-deployment.yaml
		Make sure "target" from configmap have current local ip
		Should port forward for 9090 -> Prometheus and 3000 for grafana
		Credentials are mentioned in deployment 


Ref : https://medium.com/javarevisited/springboot-app-monitoring-with-grafana-prometheus-7c723f0dec15
Grafana JSON Report ID = 4701

##Plant UML Sample "Sequence Diagram"

'''plantuml


@startuml

bff --> auth_service :Auth request
auth_service --> bff :\nAuth response

bff --> customer_service : \n Add/Edit/Delete Customer Request
customer_service --> bff :\n Add/Edit/Delete Customer Response

@enduml

'''
