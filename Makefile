all: calunivr.sh
	@chmod +x calunivr
	@mv ./calunivr /usr/local/bin/calunivr
	@mv calunivr.jar /usr/local/bin/calunivr.jar
	@echo "Ok. Usa 'caluni' per invocare il programma. "
