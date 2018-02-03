#! /usr/bin/python3

import configparser
import json
from opcua import Client
import os


def main():
    config = configparser.ConfigParser()
    config.read(os.path.join(os.path.dirname(__file__), 'wtc.cfg'))

    opcnodes = []
    with  Client("opc.tcp://10.0.146.94:40843/freeopcua/server/") as client:
        client.connect()
        wtc = client.get_objects_node().get_child("0:WTC")
        wtc_items = wtc.get_children()
        qual = 0
        for item in wtc_items:
            opcnodes.append(wtc.get_child(item.get_browse_name().to_string()).get_child("0:state"))
            if item.get_browse_name().to_string() == "0:CPU27/AS_EGRESS_REP":
                val = item.get_child("0:sample_quality")
                opcnodes.append(val)
                qual = val
                data = json.dumps(qual.get_value())
                print("HTTP/1.1 200 Ok")
                print("Content-type: application/json")
                print("Content-length: " + str(len(data)))
                print()
                print(data)
                exit(0)


if __name__ == '__main__':
    main()

