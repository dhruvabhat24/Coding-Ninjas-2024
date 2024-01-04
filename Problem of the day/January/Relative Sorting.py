def relativeSorting(arr, brr, n,  m):

    dict = {}

    result = []

 

    for a_item in arr:

        if dict.get(a_item):

            dict[a_item] += 1

        else:

            dict[a_item] = 1

 

    for b_item in brr:

        while dict.get(b_item):

            result.append(b_item)

            dict[b_item] -= 1

            if dict.get(b_item) == 0:

                dict.pop(b_item)

 

    keys = list(dict.keys())

    keys.sort()

 

    for key_item in keys:

        while dict.get(key_item) > 0:

            result.append(key_item)

            dict[key_item] -= 1

            

    return result
