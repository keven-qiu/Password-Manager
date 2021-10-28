import json
import sys


def search(website):
    """
    Search through passwords.json file and
    add to the entry widget
    Add both email/username and password
    """
    try:
        with open('../../../../passwords/passwords.json', 'r') as pwFile:
            data = json.load(pwFile)
            email = data[website]['email']
            password = data[website]['password']

    except KeyError:
        print("Password does not exist.")
    except FileNotFoundError:
        print("File does not exist")

    return str(email) + str(password)


search(sys.argv[1])
