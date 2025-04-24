def get_request_count_during_one_second(time, start_and_end_times):
    request_count = 0
    start_time = time
    end_time = time + 1000

    for start_and_end_time in start_and_end_times:
        if start_and_end_time[1] >= start_time and start_and_end_time[0] < end_time:
            request_count += 1

    print(request_count)
    return request_count

def solution(lines):
    answer = 0
    start_and_end_times = []
    for line in lines:
        _, time, duration = line.split()
        time_array = time.split(":")
        duration = float(duration.replace('s', '')) * 1000

        end_time = (int(time_array[0]) * 3600 + int(time_array[1]) * 60 + float(time_array[2])) * 1000
        start_time = end_time - duration + 1
        start_and_end_times.append([start_time, end_time])

    print(start_and_end_times)

    for start_and_end_time in start_and_end_times:
        answer = max(answer, get_request_count_during_one_second(start_and_end_time[0], start_and_end_times),
                get_request_count_during_one_second(start_and_end_time[1], start_and_end_times))

    return answer

lines =   [
"2016-09-15 20:59:57.421 0.351s",
"2016-09-15 20:59:58.233 1.181s",
"2016-09-15 20:59:58.299 0.8s",
"2016-09-15 20:59:58.688 1.041s",
"2016-09-15 20:59:59.591 1.412s",
"2016-09-15 21:00:00.464 1.466s",
"2016-09-15 21:00:00.741 1.581s",
"2016-09-15 21:00:00.748 2.31s",
"2016-09-15 21:00:00.966 0.381s",
"2016-09-15 21:00:02.066 2.62s"
]
print(solution(lines))