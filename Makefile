all: calunivr.sh
	@chmod +x calunivr.sh
	@mv ./calunivr.sh /usr/local/bin/calunivr
	@mv ./calunivr.jar /usr/local/bin/calunivr.jar
	@echo "Ok. Usa 'calunivr' per invocare il programma. "
