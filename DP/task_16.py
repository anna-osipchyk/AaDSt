from copy import copy, deepcopy
from datetime import datetime
from collections import *

def LowerBound(arr, value):
    for idx, el in enumerate(reversed(arr)):
        if isinstance(el, float):
            continue
        else:
            if el <= value:
                arr.pop(len(arr) - idx - 1)
                return el, len(arr) - idx
    return -1, -1

def LowerBoundSum(arr, value, to_start_from):
    for i in range(to_start_from, 0, -1):
        if arr[i] <= value and arr[i] != 0:
            return arr[i]
    return -1


def UpperBoundSum(arr, value):
    for idx, el in enumerate(arr):
        if el >= value:
            return el, idx
    return -1, -1

def sums(dick, overall_capacity):
    arr = [0 for _ in range(overall_capacity + 1)]
    max_idx = 0
    iter_max = 0
    freq = dict()
    for num in dick.values():
        if num in freq:
            freq[num] += 1
        else:
            freq[num] = 1
    for empty_place in dick.values():
        if not isinstance(empty_place, float):
            arr[empty_place] = empty_place
            if empty_place != 0:
                for i, already_counted in enumerate(arr):
                    if already_counted + empty_place <= iter_max + empty_place:
                        if (i != empty_place or freq[empty_place] > 1 or empty_place in dick.values()):
                            if i==empty_place:
                                freq[empty_place] -= 1
                            arr[already_counted + empty_place] = already_counted + empty_place
                            max_idx = max(already_counted + empty_place, max_idx)
                    else:

                        break
                iter_max = max_idx
    return arr
def solve(flue, values, keys):
    tmp_list, list_of_idx = [], []
    sum_of_l_b, max_sum, counter = 0, 0, 0
    copy_values = copy(values)
    while max_sum < flue and counter != len(copy_values):
        if max_sum > sum_of_l_b:
            return max_sum, list_of_idx
        sum_of_l_b = 0
        is_first_iter = True
        counter += 1
        values = copy(copy_values)
        copy_values = copy(values)
        copy_flue = flue
        tmp_list.clear()
        should_stop = False
        max_idx = 0
        while sum_of_l_b < flue and not should_stop:
            l_b, idx = LowerBound(values, copy_flue)
            if is_first_iter:
                max_idx = idx
            is_first_iter = False
            if l_b == 0:
                break
            if idx == -1:
                should_stop = True
                continue
            tmp_list.append(keys[idx])
            copy_flue -= l_b
            sum_of_l_b += l_b
            if sum_of_l_b > max_sum:
                max_sum = sum_of_l_b
                list_of_idx = copy(tmp_list)
        # if max_idx in copy_values:
        if max_idx == -1:
            continue
        else:
            copy_values.pop(max_idx)

    return max_sum, list_of_idx


def all_sums(overall_capacity, flue_a, flue_b, chambers_for_a:list, sorted_dict):

    arr = sums(sorted_dict, overall_capacity)

    u_for_a, idx = UpperBoundSum(arr, flue_a)
    if u_for_a == -1:
        idx = len(arr) - 1
    l_for_a = LowerBoundSum(arr, flue_a, idx)
    if u_for_a == -1:
        l_for_a = max(0, l_for_a)
        u_for_a = l_for_a

    l_for_a = max(0, l_for_a)
    keys = list(sorted_dict.keys())
    values = list(sorted_dict.values())

    max_sum_a_low, solve_for_a_chambers_low= solve(l_for_a, values, keys)
    max_sum_a_up, solve_for_a_chambers_up= solve(u_for_a, values, keys)
    dick = deepcopy(sorted_dict)

    ################################ case low ###########################################
    solve_for_a_chambers_low += chambers_for_a

    for key in solve_for_a_chambers_low:
        if key in sorted_dict:
            sorted_dict.pop(key)
    solve_for_a_chambers_low.sort()
    if 0 in solve_for_a_chambers_low:
        solve_for_a_chambers_low.remove(0)


    arr = sums(sorted_dict, overall_capacity)
    u_for_b, idx = UpperBoundSum(arr, flue_b)
    if u_for_b == -1:
        idx = len(arr) - 1
    l_for_b = LowerBoundSum(arr, flue_b, idx)
    if u_for_b == -1:
        l_for_b = max(0, l_for_b)
        u_for_b = l_for_b
    l_for_b = max(0, l_for_b)

    max_saved_overall_case_a_low = max(min(u_for_b, flue_b), l_for_b) +max_sum_a_low

    ################################ case up ###########################################
    solve_for_a_chambers_up += chambers_for_a

    for key in solve_for_a_chambers_up:
        if key in dick:
            dick.pop(key)
    solve_for_a_chambers_up.sort()
    if 0 in solve_for_a_chambers_up:
        solve_for_a_chambers_up.remove(0)

    arr  = sums(dick, overall_capacity)
    u_for_b, idx = UpperBoundSum(arr, flue_b)
    if u_for_b == -1:
        idx = len(arr) - 1
    l_for_b = LowerBoundSum(arr, flue_b, idx)
    if u_for_b == -1:
        l_for_b = max(0, l_for_b)
        u_for_b = l_for_b
    l_for_b = max(0, l_for_b)
    min_1  = min(u_for_b,flue_b)
    max_saved_overall_case_a_up = max(min_1, l_for_b) + min(max_sum_a_up, flue_a)

    ####################################################################################
    if max_saved_overall_case_a_up<max_saved_overall_case_a_low:
        return solve_for_a_chambers_low, max_saved_overall_case_a_low
    else:
        return solve_for_a_chambers_up, max_saved_overall_case_a_up




def s():
    start = datetime.now()
    f = open('input.txt')
    flue_a = int(f.readline())
    flue_b = int(f.readline())
    amount_of_chambers = int(f.readline())
    chambers, chambers_for_a, chambers_for_b = dict(), list(), list()
    overall_capacity = 0
    amount_a, amount_b = flue_a, flue_b
    saved_a, saved_b = 0, 0
    idx = 1

###################################################

    for line in f:
        data = line.split()
        if data[1] == '0' and data[2] != '0':
            if data[0] == data[2]:
                chambers[idx] = 0.1
                idx+=1
                continue
            b_to_save = int(data[0]) - int(data[2])
            if flue_b - b_to_save < 0:
                saved_b += min(b_to_save, flue_b)
                if min(b_to_save, flue_b) > 0:
                    chambers_for_b.append(idx)
                    idx += 1
                    flue_b= max(flue_b-b_to_save, 0)

                else:
                    flue_b = 0
                    chambers[idx] = 0.1
                    idx += 1
            else:
                flue_b-=b_to_save
                saved_b += b_to_save
                chambers_for_b.append(idx)
                idx+=1
        elif data[2] == '0' and data[1] != '0':
            if data[0] == data[1]:
                chambers[idx] = 0.1
                idx += 1
                continue
            a_to_save = int(data[0]) - int(data[1])
            if flue_a - a_to_save < 0:
                saved_a += min(a_to_save, flue_a)
                if min(a_to_save, flue_a) >0:
                    chambers_for_a.append(idx)
                    idx += 1
                    flue_a= max(flue_a-a_to_save, 0)
                else:
                    flue_a = 0
                    chambers[idx] = 0.1
                    idx+=1
            else:
                flue_a-=a_to_save
                saved_a += a_to_save
                chambers_for_a.append(idx)
                idx+=1
        else:
            chambers[idx] = int(data[0])
            idx+=1
            overall_capacity += int(data[0])

####################################################
    sorted_dict = {}
    sorted_keys = sorted(chambers, key=chambers.get)

    for w in sorted_keys:
        sorted_dict[w] = chambers[w]
    f.close()
    solve_for_a_chambers, max_saved_sum = all_sums(overall_capacity, flue_a, flue_b,
                                                          chambers_for_a, sorted_dict)
    if amount_a+amount_b <= max_saved_sum+saved_b+saved_a:
        file = open("output.txt", 'w')
        file.write(str(amount_a + amount_b) + "\n")
        string = " ".join(list(map(str, solve_for_a_chambers)))
        file.write(string)
        file.close()
    else:
        file = open("output.txt", 'w')
        file.write(str(max_saved_sum+saved_b+saved_a) + "\n")
        file.close()

#####################################################


s()
