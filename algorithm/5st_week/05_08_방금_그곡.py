'''
m = "CC#BCC#BCC#BCC#B"
musicinfos = ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]

def solution(m, musicinfos):
    answer = "(None)"
    answer_play_time = 0

    m = m.replace("C#", "c")
    m = m.replace("D#", "d")
    m = m.replace("F#", "f")
    m = m.replace("G#", "g")
    m = m.replace("A#", "a")
    m = m.replace("B#", "b")

    for musicinfo in musicinfos:
        start_time, end_time, title, score = musicinfo.split(",")
        start_hour, start_minute = map(int, start_time.split(":"))
        end_hour, end_minute = map(int, end_time.split(":"))
        play_time = (end_hour * 60 + end_minute) - (start_hour * 60 + start_minute)

        time = 0
        index = 0
        melody = ''

        score = score.replace("C#", "c")
        score = score.replace("D#", "d")
        score = score.replace("F#", "f")
        score = score.replace("G#", "g")
        score = score.replace("A#", "a")
        score = score.replace("B#", "b")

        while time < play_time:
            melody += score[index]
            time += 1
            index += 1

            if index >= len(score):
                index = 0

        if m in melody:
            if play_time > answer_play_time:
                answer = title
                answer_play_time = play_time

    return answer
'''
import math

def replace_step(m):
    return m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")

def solution(m, musicinfos):
    answer = None
    max_play_time = 0
    m = replace_step(m)

    for musicinfo in musicinfos:
        start_time, end_time, name, melody = musicinfo.split(",")
        play_time = int(end_time[:2]) * 60 + int(end_time[3:]) - int(start_time[:2]) * 60 - int(start_time[3:])

        melody = replace_step(melody)
        melody_repeated_count = math.ceil(play_time / len(melody))
        melody_played = (melody * melody_repeated_count)[:play_time]

        if m in melody_played and play_time > max_play_time:
            answer = name
            max_play_time = play_time

    if answer is None:
        return "(None)"

    return answer

m = "CC#BCC#BCC#BCC#B"
musicinfos = ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]

solution(m, musicinfos)