// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract DataRegistry {
    string private dataHash;
    address public owner;

    event DataHashUpdated(string newHash);

    constructor() {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only owner can call this function");
        _;
    }

    function registerData(string memory _dataHash) public onlyOwner {
        dataHash = _dataHash;
        emit DataHashUpdated(_dataHash);
    }

    function getDataHash() public view returns (string memory) {
        return dataHash;
    }
} 