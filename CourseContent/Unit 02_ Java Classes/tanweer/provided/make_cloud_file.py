import random

def make_file(terms, filename):
    words = []
    for term in terms:
        words += ([term] * terms[term])
    random.shuffle(words)
    with open(filename, "w") as file:
        for word in words:
            file.write(word + "\n")

def main():
    terms = {
        "object":100,
        "oriented":95,
        "programming":100,
        "class":90,
        "instance":50,
        "variable":10,
        "field":25,
        "method":25,
        "polymorphism":98,
        "encapsulation":75,
        "subclass":30,
        "superclass":30,
        "child":40,
        "parent":55,
        "program":80,
        "software":80,
        "expression":10,
        "statement":15,
        "code":85,
        "abstract":40,
        "interface":55,
        "data structure":65,
        "reuse":40,
        "extends":20,
        "implements":35,
        "super":25,
        "this":45,
        "design":40,
        "time complexity":70
    }

    make_file(terms, "word_cloud.txt")

if __name__ == "__main__":
    main()
