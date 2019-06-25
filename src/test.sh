FILES="../Tests/*"

for f in $FILES
do
	echo "Processing $f "
	java Simulation.Main $f
	echo " "
done
