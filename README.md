# Simple-zip-parser
A command-line tool for inspecting and comparing ZIP/JAR archives.
## Features
- __Inspect__ - View detailed information about ZIP file content
- __Diff__ - Compare two ZIP files and see differences in structure

## Installation
```bash
# Clone this repository
git clone https://github.com/Aleksander-Wieczorek/Simple-zip-parser.git
cd simple-zip-parser

# Run installation script
./install.sh
source ~/.bashrc
```
## Usage
### Inspect
```bash
$ zipparser inspect myarchive.zip -o output.out
```
Example output:
```json
[
    {
        "name": "myarchive/",
        "size": 0,
        "compressedSize": 0,
        "crc": 0
    },
    {
        "name": "myarchive/Hello.class",
        "size": 9,
        "compressedSize": 9,
        "crc": 3886280309
    },
    {
        "name": "myarchive/META-INF/",
        "size": 0,
        "compressedSize": 0,
        "crc": 0
    },
    {
        "name": "myarchive/META-INF/MANIFEST.MF",
        "size": 14,
        "compressedSize": 14,
        "crc": 627833228
    },
    {
        "name": "myarchive/plugin.xml",
        "size": 28,
        "compressedSize": 23,
        "crc": 3215730464
    }
]
```
### Difference
```bash
$ zipparser diff myarchive.zip mynewarchive.zip
```
Example output
```
Added:
 myarchive/Clazz.class
 myarchive/NEW_FOLDER/
 myarchive/NEW_FOLDER/new_file.c

Removed:
 myarchive/Hello.class
```
## Uninstallation
Run the uninstall script in the repository folder:
```bash
./uninstall.sh
```
