# https://jsosic.wordpress.com/2017/01/23/deleting-images-from-docker-registry/
# 
# 
# registry:
#   restart: always
#   image: registry:2
#   ports:
#     - 5000:5000
#   environment:
#     REGISTRY_HTTP_TLS_CERTIFICATE: /certs/domain.crt
#     REGISTRY_HTTP_TLS_KEY: /certs/domain.key
#     REGISTRY_AUTH: htpasswd
#     REGISTRY_AUTH_HTPASSWD_PATH: /auth/htpasswd
#     REGISTRY_AUTH_HTPASSWD_REALM: Registry Realm
#     REGISTRY_STORAGE_DELETE_ENABLED: "true"
#   volumes:
#     - /Users/stevedavis/Downloads/docker_registry/data:/var/lib/registry
#     - /Users/stevedavis/Downloads/docker_registry/certs:/certs
#     - /Users/stevedavis/Downloads/docker_registry/auth:/auth
# 

export REG_PASS='testuser:testpassword'
export HDR='"Accept: application/vnd.docker.distribution.manifest.v2+json"'
export REG_URI='https://localhost:5000/v2'

alias curl_reg="curl -k --user $REG_PASS -H $HDR"

curl_reg "${REG_URI}/_catalog"

curl_reg "${REG_URI}/delegate/tags/list"

curl_reg -s "${REG_URI}/delegate/manifests/latest" \
            | jq '.config.digest'

curl_reg -X DELETE "${REG_URI}/delegate/manifests/sha256:0f1ead74cdb655e9af5e057461093db4736789a04acbb693edb6bd34a22327bb"


docker exec -it caee \
       bin/registry garbage-collect /etc/docker/registry/config.yml
