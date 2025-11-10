#!/bin/bash
set -e

echo "Building application..."
./gradlew installDist

echo "Installing to ~/.local/bin/..."
mkdir -p ~/.local/bin

cat > ~/.local/bin/zipparser << 'EOF'
#!/bin/bash
SCRIPT_DIR="$HOME/.local/share/zipparser"
exec java -cp "$SCRIPT_DIR/lib/*" com.simplezipparser.MainKt "$@"
EOF

chmod +x ~/.local/bin/zipparser

echo "Copying libraries..."
mkdir -p ~/.local/share/zipparser
cp -r ./build/install/zipparser/lib ~/.local/share/zipparser/

echo ""
echo "Installation complete!"
echo "Run: zipparser --help"