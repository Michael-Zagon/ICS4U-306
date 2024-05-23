/**
 * The program for 306
 *
 * By: Michael Zagon
 * Version: 1.0
 * Since: 2024-05-12
 */


import { createPrompt } from 'bun-promptx'


// This is the recursive Quick Sort function.
function quickSort(arr: number[]): number[] {
    if (arr.length <= 1) {
        return arr
    } else {
        const pivot = arr[0]
        const lessThanPivot = arr.slice(1).filter(x => x <= pivot)
        const greaterThanPivot = arr.slice(1).filter(x => x > pivot)
        return [...quickSort(lessThanPivot), pivot, ...quickSort(greaterThanPivot)]
    }
}

// Asks for the user's input array
console.log('This program sorts an array using Quick Sort')
const inputArrayString = prompt('Enter your array (comma-separated values): ')
const inputArray = inputArrayString.split(',').map(Number)

// Shows the original array
console.log(`This is the Original Array: [${inputArray.join(', ')}]`)

// Sorts the array using Quick Sort
const sortedArray = quickSort(inputArray)

// Shows the sorted array
console.log(`The sorted array is: [${sortedArray.join(', ')}]`)

console.log('\nDone.')

