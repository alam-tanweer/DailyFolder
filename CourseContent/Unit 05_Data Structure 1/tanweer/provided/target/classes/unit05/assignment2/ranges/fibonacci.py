
def fibonacci(n, fn_1=1, fn_2=0):
    if n == 1:
        return fn_1
    elif n == 0:
        return fn_2
    else:
        temp = fn_1
        fn_1 = fn_1 + fn_2
        fn_2 = temp
        return fibonacci(n-1, fn_1, fn_2)


def main():
    for i in range(35):
        print(fibonacci(i))

if __name__ == "__main__":
    main()