import java.text.DecimalFormat;

public class DecompositionLU {
    private double[] resultat,Y;
    private MatrixClass matrix;
    private Vector vector;
    private int n;
    private String type;
    private String matL,matU;
    private int bandWidth;
    private double[][] matriceL,matriceU;
    public DecompositionLU(MatrixClass mat,Vector vect){
        matrix= mat;
        vector=vect;
        n=matrix.getSize();
        type= matrix.getType();
        resultat= new double[n];
        Y=new double[n];
        matriceL=new double[n][n];
        matriceU=new double[n][n];
        bandWidth=MatrixClass.bandwidth;
        resoudre();
    }
    public void decompose(){
        for(int i=0;i<n;i++){
            matriceL[i][i]=1;
            for(int j=0;j<=i-1;j++){
                matriceL[i][j]=matrix.matrix[i][j];
                for(int k=0;k<=j-1;k++){
                    matriceL[i][j]-=matriceL[i][k]*matriceU[k][j];
                }
                matriceL[i][j]/=matriceU[j][j];
            }
            for(int j=i;j<n;j++){
                matriceU[i][j]=matrix.matrix[i][j];
                for(int k=0;k<=i-1;k++){
                    matriceU[i][j]-=matriceL[i][k]*matriceU[k][j];
                }
            }
        }
    }
    public void resoudre_matriceDense(){
        decompose();
        matL=afficheMat(matriceL);
        matU=afficheMat(matriceU);
        for (int i = 0; i < n; i++) {
            double sum = 0.0;
            for (int j = 0; j < i; j++) {
                sum += matriceL[i][j] * Y[j];
            }
            Y[i] = (vector.vector[i] - sum) / matriceL[i][i];
        }
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matriceU[i][j] * resultat[j];
            }
            resultat[i] = (Y[i] - sum) / matriceU[i][i];
        }
    }
    public String getL(){
        return matL;
    }
    public String getU(){
        return matU;
    }
    public void resoudre(){
        switch (type) {
            case "dense":
                resoudre_matriceDense();
                break;
            default:
            break;
        }
                
    }
    public String afficheMat(double[][] matrice) {
        StringBuilder matrixString = new StringBuilder("<html><table>");
        DecimalFormat format = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            matrixString.append("<tr>");
            for (int j = 0; j < n; j++) {
                matrixString.append("<td>").append(format.format(matrice[i][j])).append("</td>");
            }
            matrixString.append("</tr>");
        }
        matrixString.append("</table></html>");
        return matrixString.toString();
    }
    public String afficheVector(){
        DecimalFormat format = new DecimalFormat("#.##");;
        StringBuilder vectorString = new StringBuilder("<html><table>");
        for (int i = 0; i < n; i++) {
            String chaine = format.format(resultat[i]);
            vectorString.append("<tr>").append(chaine).append("</tr>");
           
        }
        vectorString.append("</table></html>");
        return vectorString.toString(); 
    }

}
