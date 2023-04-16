Promethes Grafana
	1. Deployments are in monitoring name space, so create name space
		kubectl create ns monitoring
	2. Apply kubernetese config map
		kubectl apply -f prometheus-config.yaml
			Make sure "target" from configmap have current local ip
	3. Apply grafana deployment file - grafana-deployment.yaml
		Should port forward for 9090 -> Prometheus and 3000 for grafana
		Credentials are mentioned in deployment file
