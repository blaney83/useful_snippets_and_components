// Given a social network containing nn members and a log file
// containing mm timestamps at which times pairs of members
// formed friendships, design an algorithm to determine the
// earliest time at which all members are connected (i.e., every
// member is a friend of a friend of a friend ... of a friend).
// Assume that the log file is sorted by timestamp and that
// friendship is an equivalence relation. The running time of
// your algorithm should be m \log nmlogn or better and use
// extra space proportional to nn.
// Members: [1,2,3,4,5]
// Time: {
// 0: (1,2),
// 1: (2,3),
// 2: (3,4)
// }

public class TotalSocialConnection {
    //index refers to member, value refers to most recent connection
    private int[] members;
    //index refers to member, value refers to total "friends" per member
    private int[] networkSize;
    //stores total members
    private int numMembers;
    //time in double format, connection as a pair of int memberId's
    private Map<Double, int[]> connectionTimes;

    public TotalSocialConnection(int numMembers, LinkedHashMap<Double, int[]> timeSheet){
        members = new int[numMembers];
        networkSize = new int[numMembers];
        this.numMembers = numMembers;
        connectionTimes = timeSheet;

        for(int i = 0; i < numMembers; i ++){
            members[i] = i;
            networkSize[i] = 1;
        }
    }

    private int root(int memId) {
        while (memId != members[memId]) {
            members[memId] = members[members[memId]];
            memId = members[memId];
        }
        return memId;
    }

    private boolean union(final int mem1, final int mem2) {
        int root1 = root(mem1);
        int root2 = root(mem2);

        if(root1 == root2){
            return false;
        }

        if (networkSize[mem1] <= networkSize[mem2]) {
            members[root1] = root2;
            networkSize[root2] += networkSize[root1];
            if(networkSize[root2] == numMembers){
                return true;
            }else{
                return false;
            }
        }else{
            member[root2] = root1;
            networkSize[root1] += networkSize[root2];
            if(networkSize[root1] == numMembers){
                return true;
            }else{
                return false;
            }
        }
    }

    public double findFirstCompleteNetwork(){
        for(Map<Double, int[]>.Entry timeEntry : (Iterable) connectionTimes){
            if(union(timeEntry.getValue[0], timeEntry.getValue[1])){
                return timeEntry.getKey();
            }
        }
        return(-1);
    }

}