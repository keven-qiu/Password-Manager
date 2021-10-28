import json
import sys


def saveEntries(website, email, password):
    """
    Save entries entered by user to
    "passwords.json"
    """

    newData = {
        website: {
            "email": email,
            "password": password
        }
    }

    if len(website) and len(password):
        try:
            with open('../../../../passwords/passwords.json', 'rw') as pwFile:
                data = json.load(pwFile)
                data.update(newData)
        except FileNotFoundError:
            with open('../../../../passwords/passwords.json', 'w') as pwFile:
                json.dump(newData, pwFile, indent=4)
                sys.stderr.write("File not found\n")
        else:
            with open('../../../../passwords/passwords.json', 'w') as pwFile:
                json.dump(data, pwFile, indent=4)
    else:
        sys.stderr.write("One or more fields blanks\n")


saveEntries(sys.argv[1], sys.argv[2], sys.argv[3])
